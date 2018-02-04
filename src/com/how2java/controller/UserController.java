package com.how2java.controller;

import com.how2java.Constant;
import com.how2java.pojo.JsonResponse;
import com.how2java.pojo.User;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.logging.Logger;


@RequestMapping("/user")
@Controller
public class UserController {
    Logger logger = Logger.getLogger(UserController.class.getSimpleName());
    @Autowired
    UserService userService;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<User> register(User user) {
        logger.info(user.toString());
        if (user == null) {
            return new JsonResponse(401, "参数为空");
        }
        for (int i = 0; i < userService.count(); i++) {
            if (user.getUsername().equals(userService.list().get(i).getUsername())) {
                return new JsonResponse(402, "该用户名已被注册");
            }
        }
        userService.insert(user);
        return new JsonResponse(200, "注册成功");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setImgUrl("asdasd");
        user.setUsername("asdasdasd");
        user.setPassword("asdasd");
        return user;
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse login(String username, String password) {
        if (username == null || password == null) {
            return new JsonResponse(401, "参数为空");
        }
        for (int i = 0; i < userService.count(); i++) {
            if (username.equals(userService.list().get(i).getUsername()) &&
                    password.equals(userService.list().get(i).getPassword())) {
                int id = userService.list().get(i).getId();
                return new JsonResponse(200, "登录成功", id);
            }
        }
        return new JsonResponse(402, "账号或密码错误");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity<Void> deleteUser(Integer id) {
        userService.delete(id);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity(httpStatus);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<User> getUserById(Integer id) {
        User user = userService.query(id);
        if (user == null) {
            return new JsonResponse<>(400, "找不到该用户", user);
        }
        return new JsonResponse<>(200, Constant.SUCCESS, user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<Void> update(User user, @RequestParam(value = "file", required = false) CommonsMultipartFile[] files, HttpServletRequest request) {
        String fileName = "";
        if (user == null) {
            return new JsonResponse<>(402, "参数不能为空", null);
        }
        if (files != null && files.length > 0) {
            //获得项目路径
            ServletContext sc = request.getSession().getServletContext();
            //上传位置
            String path = sc.getRealPath("/img") + "/";   //设定文件保存的目录
            File f = new File(path);
            if (!f.exists()) {
                f.mkdirs();
            }
            for (int i = 0; i < files.length; i++) {
                //获得原始文件名
                fileName = files[i].getOriginalFilename();
                System.out.println("原始文件名:" + fileName);
                //
                if (!files[i].isEmpty()) {
                    try {
                        FileOutputStream fos = new FileOutputStream(path + fileName);
                        InputStream in = files[i].getInputStream();
                        int b = 0;
                        while ((b = in.read()) != -1) {
                            fos.write(b);
                        }
                        fos.close();
                        in.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                user.setImgUrl(Constant.BASE_IMG_URL + fileName);
                System.out.println("上传图片到:" + path + fileName);
            }
        }

        User userResult = userService.query(user.getId());
        if (userResult == null) {
            return new JsonResponse<>(403, "不存在该用户");
        }
        userService.update(user);
        return new JsonResponse<>(200, "修改成功");
    }


    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse<List<User>> getAllUser() {
        List<User> users = userService.list();
        return new JsonResponse(200, "success", users);
    }

}
