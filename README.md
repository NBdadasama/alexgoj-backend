# 一、OJ 判断系统

## 1、 项目介绍



OJ = Online Judge 在线判题评测系统



用户可以选择题目，在线做题，编写代码并且提交代码；系统会对用户提交的代码，根据我们出题人设置的答案，来判断用户的提交结果是否正确。



**OJ 系统最大的难点在于判题系统**



用于在线评测编程题目代码的系统，能够根据用户提交的代码、出题人预先设置的题目输入和输出用例，进行编译代码、运行代码、判断代码运行结果是否正确。



比如：ACM(程序设计竞赛)，也是需要依赖判题系统来检测参赛者的答案是否合理



## 2、OJ 系统概念



AC 表示你的题目通过，结果正确



题目限制：时间限制、内存限制



题目介绍



题目输入



题目输出



题目输入用例



题目输出用例



普通测评：管理员设置题目的输入和输出用例，比如我输入1，你要输出2才是正确的：交给判题机去执行用户的代码，给用户的代码 喂 输入用例，比如1，看用户程序的执行结果是否和标准答案的输出一致。
(比对用例文件)



特殊测评(SPJ)：管理员设置题目的输入和输出，比如我输入1，用户的答案只要是>0或<2都是正确的；



特判程序，不是通过对比用例文件是否一致这种死板的程序来检验，而是要专门根据这道题目写一个特殊的判断程序，比如



- 程序接收题目的输入：1

- 标住输出用例：2

- 用户得到的结果：1.5



特判程序根据这些值来比较是否正确。



交互测评：让用户输入一个例子，就给一个输出结果，交互比较灵活，没办法通过简单的、死板的输入输出文件来搞定



### 系统安全性



不能让用户随便引入包、随便遍历、暴力破解，需要使用正确的的算法。=>安全性



判题过程是异步的=>异步化（编译是需要时间的）



提交之后，会生成一个提交记录，有运行的结果以及运行信息（时间限制、内存限制）



## 3、项目背景



OJ（Online Judge）系统是一个在线编程评测系统，用户可以选择题目、编写代码并提交代码进行评测。然而，OJ 系统的核心难点在于判题系统的设计与实现，需要能够编译、执行和评测用户代码，并与出题人设置的答案进行对比。



目标是开发一个高效、稳定的 OJ 在线判题评测系统，支持多种编程语言，能够自动编译、执行和评测用户的代码。



## 4、OJ系统调研



1. https://github.com/HimitZH/HOJ (适合学习)

1. https://github.com/QingdaoU/OnlineJudge (python，不好学，很成熟)

1. https://github.com/hzxie/voj (星星没那么多，没那么成熟，但相对好学)

1. https://github.com/fleaking/uoj (php实现的)

1. https://github.com/zhblue/hustoj (成熟，但是php实现)

1. https://github.com/hydro-dev/Hydro (功能强大，Node.js实现)





## 5、系统开发流程



1. 项目介绍、项目调研、需求分析

1. 核心业务流程

1. 项目要做的功能（功能模块）

1. 技术选型（技术预研）

1. 项目初始化

1. 项目开发

1. 测试

1. 优化

1. 代码提交、代码审核

1. 产品验收

1. 上线





## 6、项目核心亮点



1.  权限校验

- - 谁能提代码，谁不提代码

2. 代码沙箱（安全沙箱）

- -  用户代码藏毒：写个木马文件、修改系统权限

- -  沙箱：隔离的、安全的环境，用户的代码不会影响到沙箱之外的系统的运行

- -  资源分配：系统的内存就2个G,用户疯狂占用资源占满你的内存，其他人就用不了了。所以要限制用户程序的占用资源。

3. 判题规则

- - 题目用例的比对，结果的验证

4. 任务调度

- - 服务器资源有限，用户要排队，按照顺序去依次执行判题，而不是直接拒绝



## 7、项目功能



### 7.1 已有功能



1. 题目模块

1. 1. 创建题目（管理员）
2. 删除题目（管理员）
3. 修改题目（管理员）
4. 搜索题目（用户）
5. 在线做题
6. 提交题目代码

1. 用户模块

1. 1. 注册
2. 登录
3. 用户管理（管理员）

1. 判题模块

1. 1. 提交判题（结果是否正确与错误）
2. 错误处理（内存益出、安全性、超时）
3. 自主实现 代码沙箱（安全沙箱）
4. 开放接口（提供一个独立的新服务）



### 7.2 扩展功能



1. 支持多种语言

1. Remote Judge

1. 完善的评测功能：普通测评、特殊测评、交互测评、在线自测、子任务分组评测、文件

1. 统计分析用户判题记录

1. 权限校验



## 8、核心业务流程



![image-20230922015426738](OJ%20系统.assets/image-20230922015426738.png)

###  时序图

![image-20230922015500813](OJ%20系统.assets/image-20230922020932712.png)



> 判题服务：获取题目信息、预计的输入输出结果，返回给主业务后端：用户的答案是否正确
> 
> 代码沙箱：只负责运行代码，给出程序运行的结果，不用管用户提交的程序是否正确。



## 9、技术选型



### 前端



1. Vue3

1. Acro Design组件库

1. 在线编辑器

1. 在线文档浏览



### 后端



1. Java进程控制

1. Java安全管理器

1. JVM

1. 虚拟器（云服务器）

1. Docker（代码沙箱实现）

1. SpringCloud 微服务

1. 消息队列 RabbitMQ

1. SpringBoot

1. MySQL



## 10、OJ架构设计



![image-20230922015717940](OJ%20系统.assets/image-20230922015717940.png)