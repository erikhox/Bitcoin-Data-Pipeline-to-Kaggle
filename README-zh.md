## 项目介绍

这是一个我为了在学期开始前练习我的Java技能而制作的个人项目。我一直喜欢数据并且生活在数据中，所以我想做一个与数据相关的项目。在思考自己能接触到和使用的数据时，我想到了金融。我最终选择跟踪比特币，因为它是24/7实时更新的数据，比股票数据更容易获取。

以下是我的程序逻辑，供理解参考：

* 每分钟抓取这个网站的实时数据 [https://bitcointicker.co/coinbase/btc/usd/10m/](https://bitcointicker.co/coinbase/btc/usd/10m/)
* 整理数据并将其写入CSV文件的新行
* 每24小时在凌晨12:00通过Python脚本上传数据

![截图](https://github.com/user-attachments/assets/4ab86c76-f8a0-43e9-9123-133590670eb8)

## 入门

以下是如何在本地设置项目的示例说明。
按照以下简单步骤即可使本地副本运行起来。

### 必要条件

- **Java 23**（用于运行项目）
- **Python 3**（用于上传脚本）
- **Maven**（用于构建项目）
- **Kaggle API密钥**（用于上传数据到Kaggle）

### 安装

_以下是如何向您的受众提供安装和设置应用程序的说明。此模板不依赖任何外部依赖项或服务。_

1. 按照“Kaggle API认证”部分的说明获取Kaggle json [kaggle.com/docs/api](https://www.kaggle.com/docs/api)
2. 在Windows或Linux上安装Maven
3. 将json文件放在Windows和Linux相应的文件夹中
    * C:\Users\用户名\.kaggle\
    * ~/.kaggle/
4. 安装requirements.txt中的依赖
   ```sh
   pip install -r requirements.txt
   ```
5. 编辑位于 dataPipelineProject/src/main/csv_files/dataset-metadata.json 的json文件
6. 进入项目所在目录并构建Maven项目
   ```sh
   mvn clean package
   ```
7. 运行项目文件夹中创建的target文件夹里的.jar文件以开始数据采集
8. 运行Python文件，或自动化上传数据到Kaggle

## 使用

此项目用于抓取比特币数据并每天将其上传到Kaggle。我个人在运行Ubuntu Linux的Raspberry Pi 5上运行它，效果非常好。如果你愿意，也可以轻松修改代码以适应任何你想抓取的网站和数据。我没有特别设计它来做更改，所以如果有任何问题，请见谅。你可以在Kaggle上查看数据集：

[kaggle.com/datasets/erikhox/bitcoin-minute-data/data](https://www.kaggle.com/datasets/erikhox/bitcoin-minute-data/data)

## 贡献

开源项目永远是开放的，如果你有任何想法能让项目更好，欢迎贡献！
1. Fork 项目
2. 创建特性分支 (git checkout -b feature/AmazingFeature)
3. 提交你的更改 (git commit -m 'Add some AmazingFeature')
4. 推送到分支 (git push origin feature/AmazingFeature)
5. 打开Pull Request

## 许可证

根据Unlicense许可证分发。更多信息请查看 LICENSE.txt 文件。

## 联系

Erik Hoxhaj: [linkedin](https://www.linkedin.com/in/erikhoxhaj/) - [个人网站](https://www.erikhoxhaj.com/) - erik.hoxhaj@outlook.com
项目链接: [github.com/erikhox/Bitcoin-Data-Pipeline-to-Kaggle ](https://github.com/erikhox/Bitcoin-Data-Pipeline-to-Kaggle )