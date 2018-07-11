# springboot + vue的简单案例
### 功能点
* 登录
* 注册
### 技术栈
* java
* spring boot
* vue
* mybatis
* mysql
* element-ui
### 项目搭建步骤
* spring boot的搭建步骤很简单,这里简单记录一下
  * 使用IDEA新建项目,选择Spring Initializr,输入项目信息,打包方式选`war`,这是重点,当然你想用`jar`也可以,但为了之后能部署在tomcat等容器里还是       `war`比较好
  * 接下来选择依赖包,因为要用springmvc所以勾选Web项中的Web,要使用数据库所以勾选SQL项中的MySql驱动和MyBatis依赖
  * 接下来就是选择项目路径等操作,就不说了
* vue的搭建较为复杂,这里给出详细步骤
  * 安装node.js,安装后在控制台中输入以下命令,显示版本号则表示安装成功
    ```
    npm -v
    node -v
    ```
  * 安装淘宝镜像提升下载速度,之后可以使用cnpm代替npm命令
    ```
    npm install -g cnpm --registry=https://registry.npm.taobao.org
    ```
  * 全局安装vue-cli脚手架
    ```
    npm install --global vue-cli
    ```
  * 创建vue项目,`install vue-router?`之后全选否,暂时用不上
    ```
    vue init webpack vue-demo
    ```
  * 进入项目路径安装依赖包
    ```
    cd vue-demo
    npm install
    ```
  * 安装饿了么团队的element-ui
    ```
    npm install element-ui -S (-S等于--save,表示该项目使用)
    ```
  * 安装axios
    ```
    npm install axios -S
    ```
  * 至此,vue项目就算搭建完成了,我建议把项目导入webstorm进行后续开发
### 项目本地开发运行步骤
  * 后台spring boot运行步骤
    使用IDEA工具栏Maven Projects的Plugins `spring-boot:run`
  * 前端vue运行步骤(项目路径下)
    ```
    npm run dev
    ```
  * 输入`http://localhost:8081/`即可调试程序
### 项目打包运行步骤
  * vue打包步骤(项目路径下)
    ```
    npm run build
    ```
  * spring boot打包步骤
    将之前vue打包生成的dist目录下的所有文件复制到spring-boot-demo中src/main/resources/static/路径下,使用IDEA工具栏Maven Projects的LifeCycle       `package`,会生成一个war包
  * 运行步骤
    `java -jar xmos.war`使用内部tomcat运行或者把war包放在外部tomcat的webapps目录下来启动服务
### 项目开发需要注意的地方
* axios跨域(开发期间需要,生产上不需要)
  * 修改vue-demo中config/index.js的proxyTable为如下代码
    ```
    proxyTable: {
      '/': {
        target: 'http://localhost:8080/xmos', //表示/开头的请求会被替换为target内容
        changeOrigin: true //表示开启代理
      }
    }
    ```
* 设置axios的全局baseUrl(开发期间需注释掉,生产上才启用)
  * 在main.js中添加如下代码
    ```
    axios.defaults.baseURL = 'http://localhost:8080/xmos'
    ```
    这样的好处是后台项目名变了后前台方便修改,但这里也有一个坑,如果写了localhost那么用ip登陆页面后请求无法发送到后台,解决的办法是修改localhost为后台     服务器的ip,但这样也有一个问题,假如后台服务器的ip变了,难道又修改baseURL然后重新打包一次吗?其实不用这么麻烦,我提供一个简单的方法.找到打包后生成的     dist/static/js目录下的app开头的js文件,搜索文件里面的内容,直接修改ip为新的服务器ip,然后重启后台服务即可
* 设置生产上的静态资源访问根路径
  * 修改vue-demo中config/index.js的build为如下代码
    ```
    //发布后资源的路径
    assetsPublicPath: '/xmos'
    ```
