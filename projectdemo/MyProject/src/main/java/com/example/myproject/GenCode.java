package com.example.myproject;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class GenCode {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/myproject?useSSL=false&autoReconnect=true&characterEncoding=utf8",
                        "root",
                        "123456")
                .globalConfig(builder ->
                        builder.author("FengJiaqi") // 设置作者
                                .enableSwagger() // 开启 swagger 模式
                )
                .packageConfig(builder ->
                        builder.parent("com.example") // 设置父包名
                                .moduleName("myproject") // 设置父包模块名
                )
                .strategyConfig(builder ->
                        builder.addInclude("tb_user")
                )
                .execute();
    }
}
