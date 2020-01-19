# 一、personmall
服务器用的阿里云服务器，搭好项目先在服务器上安装jdk MySQL zookeeper tomcat redis 等
# 打包
打包springboot 
按照架构依次打包  
只有user服务两个jar包，将两个jar包放到服务器上，启动:nohup java -jar 包名 &  
url测试http://115.28.184.173:8060/getAllUser  
# 二、安装遇到的问题
## java： 
sudo tar -zxvf jdk-8u152-linux-x64.tar.gz -C /usr/local/java/ 
(使用tar解压文件到指定目录时出现Not found in archive是因为没有设置-C这个参数（create），解压后的文件只有通过设置-C（注意要大写）这个参数，创建默认文件夹才能被成功解压，如需要把/root下的jdk-7u67-linux-
x64.tar.gz解压到/usr/local/java/下，需要键入如下命令（注意确保当前目录是用户所在目录，若不是先键入cd ~，使处于用户所在目录）)
## 防火墙几个常用命令
重新载入
firewall-cmd --reload
查看
firewall-cmd --zone=public --query-port=80/tcp
删除
firewall-cmd --zone=public --remove-port=80/tcp --permanent

同时附上其他几个常用指令
关闭防火墙命令：systemctl stop firewalld.service
开启防火墙：systemctl start firewalld.service
关闭开机自启动：systemctl disable firewalld.service
开启开机启动：systemctl enable firewalld.service
## mysql：
防火墙开放对外端口firewall-cmd --zone=public --add-port=3306/tcp --permanent
## tomcat :
防火墙开放对外端口firewall-cmd --zone=public --add-port=8080/tcp --permanent
## zookeeper：
cp -r zookeeper-3.4.11 ../zookeepe -r 会拷贝文件夹——包括下一级的子文件夹，以及子文件夹中的子文件夹，余此类推。  
开机自启脚本：  
来到etc/init.d目录  
新建 vi zookeeper  
写入（#!/bin/bash  
   #chkconfig:2345 20 90  
   #description:zookeeper  
   #processname:zookeeper  
   ZK_PATH=/opt/zookeeper  
   export JAVA_HOME=/opt/jdk1.8.0_152  
   case $1 in  
            start) sh  $ZK_PATH/bin/zkServer.sh start;;  
            stop)  sh  $ZK_PATH/bin/zkServer.sh stop;;  
            status) sh  $ZK_PATH/bin/zkServer.sh status;;  
            restart) sh $ZK_PATH/bin/zkServer.sh restart;;  
            *)  echo "require start|stop|status|restart"  ;;  
   esac  
）  
执行Chkconfig –add zookeeper
./zkServer.sh start ./zkServer.sh status 启动zookeeper 启动状态
## redis
$ wget http://download.redis.io/releases/redis-2.8.17.tar.gz
$ tar -zxvf redis-2.8.17.tar.gz
$ cd redis-2.8.17
$ make
后台启动：vi redis.conf	注掉bind 127.0.0.1（外网访问） 找到daemonize yes 守护线程 保存 防火墙（firewall-cmd --zone=public --add-port=6379/tcp --permanent）启动  ./src/redis-server ./redis.conf 
# 三、dubbo
dubbo-admin是个jar包，先解压，然后配置dubbo自启脚本  
**进入/etc/init.d vi dubbo-admins输入脚本**  
（#!/bin/bash
#chkconfig:2345 20 90  
#description:dubbo-admin       
#processname:dubbo-admin  
CATALINA_HOME=/opt/apache-tomcat-8.5.24  
export JAVA_HOME=/usr/local/java/jdk1.8.0_152  
case $1 in  
start)  
        echo "Starting Tomcat..."  
        $CATALINA_HOME/bin/startup.sh  
        ;;  

stop)  
        echo "Stoping Tomcat..."  
        $CATALINA_HOME/bin/shutdown.sh  
        ;;  
restart)  
        echo "Stoping Tomcat..."  
        $CATALINA_HOME/bin/shutdown.sh  
        sleep 2  
        echo  
        echo "Starting Tomcat..."  
        $CATALINA_HOME/bin/startup.sh  
        ;;  
*)  
        echo "Usage: tomcat {start|stop|restart}"  
        ;;esac  
        )  
执行chkconfig --add dubbo-admin  
