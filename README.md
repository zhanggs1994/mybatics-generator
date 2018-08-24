# mybatics_generator样例
* 1.在IDEA中创建一个maven工程
* 2.在maven工程的pom文件中添加mybatis-generator-maven-plugin插件

````xml
<build>
        <plugins>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.2</version>
                <configuration>
                    <verbose>true</verbose>
                    <overwrite>true</overwrite>
                </configuration>
            </plugin>
        </plugins>
    </build>
````

* 3.在src/main/resources目录下创建两个配置文件，generatorConfig.xml和generator.properties  
   * generatorConfig.xml文件

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <!DOCTYPE generatorConfiguration
             PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
             "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
     <generatorConfiguration>
         <!--导入属性配置 -->
         <properties resource="generator.properties"></properties>
     
         <!--指定特定数据库的jdbc驱动jar包的位置 -->
         <classPathEntry location="${jdbc.driverLocation}"/>
     
         <context id="default" targetRuntime="MyBatis3">
     
     
             <!-- optional，旨在创建class时，对注释进行控制 -->
             <commentGenerator>
                 <property name="suppressDate" value="true" />
             </commentGenerator>
     
     
             <!--jdbc的数据库连接 -->
             <jdbcConnection driverClass="${jdbc.driverClass}" connectionURL="${jdbc.connectionURL}" userId="${jdbc.userId}" password="${jdbc.password}">
             </jdbcConnection>
     
     
     
             <!-- 非必需，类型处理器，在数据库类型和java类型之间的转换控制-->
             <javaTypeResolver >
                 <property name="forceBigDecimals" value="false" />
             </javaTypeResolver>
     
             <!-- Model模型生成器,用来生成含有主键key的类，记录类 以及查询Example类
                 targetPackage     指定生成的model生成所在的包名
                 targetProject     指定在该项目下所在的路径
             -->
             <javaModelGenerator targetPackage="com.xiaoju.dqa.jazz.dao.model" targetProject="src/main/java">
                 <!-- 是否对model添加 构造函数 -->
                 <property name="constructorBased" value="true"/>
     
                 <!-- 是否允许子包，即targetPackage.schemaName.tableName -->
                 <property name="enableSubPackages" value="false"/>
     
                 <!-- 建立的Model对象是否 不可改变  即生成的Model对象不会有 setter方法，只有构造方法 -->
                 <property name="immutable" value="true"/>
     
                 <!-- 是否对类CHAR类型的列的数据进行trim操作 -->
                 <property name="trimStrings" value="true"/>
             </javaModelGenerator>
     
             <!--Mapper映射文件生成所在的目录 为每一个数据库的表生成对应的SqlMap文件 -->
             <sqlMapGenerator targetPackage="mybatis-mapper" targetProject="src/main/resources">
                 <property name="enableSubPackages" value="false"/>
             </sqlMapGenerator>
     
     
             <!-- 客户端代码，生成易于使用的针对Model对象和XML配置文件 的代码
                     type="ANNOTATEDMAPPER",生成Java Model 和基于注解的Mapper对象
                     type="MIXEDMAPPER",生成基于注解的Java Model 和相应的Mapper对象
                     type="XMLMAPPER",生成SQLMap XML文件和独立的Mapper接口
             -->
             <javaClientGenerator targetPackage="com.xiaoju.dqa.jazz.dao.mapper" targetProject="src/main/java" type="MIXEDMAPPER">
                 <property name="enableSubPackages" value=""/>
                 <!--
                         定义Maper.java 源代码中的ByExample() 方法的可视性，可选的值有：
                         public;
                         private;
                         protected;
                         default
                         注意：如果 targetRuntime="MyBatis3",此参数被忽略
                  -->
                 <property name="exampleMethodVisibility" value=""/>
                 <!--
                                                方法名计数器
                   Important note: this property is ignored if the target runtime is MyBatis3.
                  -->
                 <property name="methodNameCalculator" value=""/>
     
                 <!--
                                                     为生成的接口添加父接口
                  -->
                 <property name="rootInterface" value=""/>
     
             </javaClientGenerator>
     
             <table tableName="hiveTable" domainObjectName="HiveTable"
                    enableCountByExample="false" enableUpdateByExample="false"
                    enableDeleteByExample="false" enableSelectByExample="false"
                    selectByExampleQueryId="false">
             </table>
     
             <table tableName="hiveLocation" domainObjectName="HiveLocation"
                    enableCountByExample="false" enableUpdateByExample="false"
                    enableDeleteByExample="false" enableSelectByExample="false"
                    selectByExampleQueryId="false">
             </table>
     
         </context>
     </generatorConfiguration>
     ```

     

   * generator.properties文件

     ```xml
     #数据库连接java包
     jdbc.driverLocation=D:/Maven-Repository/mysql/mysql-connector-java/5.1.45/mysql-connector-java-5.1.45.jar
     jdbc.driverClass=com.mysql.jdbc.Driver
     jdbc.connectionURL=jdbc:mysql://localhost:3306/jazz?useUnicode=true&characterEncoding=utf-8
     jdbc.userId=root
     jdbc.password=root
     ```

* 4.在IDEA中添加Run选项，使用mybatis-generator-maven-plugin

   run->edit configrations->maven

   配置如下:

   * 1）Name写generator会在run菜单生成一个名叫generator的选项；
   * 2）CommandLine写要执行的命令，mybatis-generator:generate  -e
   * 3）working directory写你pom所在的工程。

   

   





