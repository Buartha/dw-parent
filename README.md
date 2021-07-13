# ReadMe #

This is the main code for EBIDSUN DW project.

## 1.Modules

### 1.1 模块结构

Parent module
Property | Value
---|---
groupId | com.bidsun.dw
artifactId | BocStreaming

Package | Description
---|---
com.bidsun.dw.streaming | 实时计算模块
com.bidsun.dw.udf/udaf | 数据仓库自定义函数
com.bidsun.dw.sink | 实时计算数据入库
com.bidsun.dw.test | 测试demo
### 1.2 离线数仓代码
待补充……

## 2. Contribution guidelines

### 2.1 实时计算任务提交方式:
```
待补充……
```
### 2.2 离线数仓任务 
```
待补充……
```

### 2.3 代码打jar包方式
```
mvn clean && mvn package
```
### 2.4 注意事项

* Process
    1. 开发人员开发新 Feature 或解决 Bug 时建立新 branch, branch 的名称形如 `xxx-feat???` 或 `xxx-bug???`, 其中 xxx 是开发人员 id
    1. 开发人员在新建的 branch 上开发，可随时 commit, push
    1. 开发人员不能直接 push 到 master, production, develop 分支上，需提交 Pull request
    1. 管理员收到 Pull request 后，发起 Code review, Review 通过后 Merge 该分支
    1. Merge 过的 branch 由开发人员自行清理，也可以由管理员集中清理，不能再用于新的开发
    1. 从 develop 到 production, master 的 Merge 由管理员进行
* Writing tests
    1. 独立的测试工具放在 streaming-test 模块中
    1. Unit Test 放在自己的模块中，遵守 Maven 惯例
* Code review
* Other guidelines
    1. develop 和 production 有多个版本，branch 名为 develop-{version} 和 production-{version}
    1. 版本 Release 后，相应的 production branch 锁定，develop branch 作废

## 3.Q&A

### 3.1 How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### 3.2 Who do I talk to? ###

* Repo owner or admin
* Other community or team contact


