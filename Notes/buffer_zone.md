

# Refresh Automatically

```java
resp.setHeader("Refresh", "1")
```

# SetRedirect

```java
resp.setStatus(302);
resp.setHeader("Location", "https://www.sogou.com");
resp.sendRedirect("http://www.sogou.com");
```

# Reload the Messages

```JS
//refresh the web page automatically
function getMessages() {
	$.ajax({
        type: 'get',
        url: 'message',
        success: function(body){
            for(let message of body){
                //read value
                alert(message.from + message.to + message.message)
            }
        }
    })    
}
```

# 对象和JSON字符串之间的转换

```java
objectMapper.readValue;
objectMapper.writeValueAsString;
```

```JS
JSON.parse;
JSON.stringify;
```

# Main

```java
```

# MySQL

DBUtil

```mysql
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/MyDatabase?characterEncoding=utf-8&userSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "222";

    private static DataSource dataSource = null;
    private static DataSource getDataSource() {
        if (dataSource == null){
            dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setUrl(URL);
            ((MysqlDataSource)dataSource).setUser(USERNAME);
            ((MysqlDataSource)dataSource).setPassword(PASSWORD);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```













# QtCore

时间，QSize，Qt

# QtQuick

包括视觉类型和牵引类型、动画、模型和融合粒子效果

QML：提供了一种高度可读的声明式JSON语法，支持命令式JavaScript表达式和动态属性绑定相结合





## 时间

```Python
from PyQt6.QtCore import QDate, QTime, QDateTime, Qt
date = QDate.currentDate()
print(date.toString(Qt.DateFormat.ISODate))
print(date.toString(Qt.DateFormat.RFC2822Date))

time = QDateTime.currentDateTime()
print(time.toSting())

datatime = QTime.currentTime()
print(time.toString(Qt.DateFormat.ISODate))
```



## 窗口类

### QWidget

所有用户界面对象的基类，小部件是用户界面的一个重要点，从窗口系统接收鼠标键盘和其他事件并绘制自己的表示



### QMainWindow

提供一个主应用程序窗口，提供一个框架用于构建应用程序用户界面

QMainWindow有自己的布局，可以添加QToolbars，QDockableWidgets，QMenubar和QStatusBar

```Python
from PyQt6.QtWidgets import QApplication, QMainWindow
import sys
#app = QApplication([])
app = QApplication(sys.argv)

#创建窗口对象
window = QMainWindow()
#下面的这些属性QWidget，QDialog是没有的
#在下方的状态栏添加
window.statusBar().showMessage("Welcome to PyQt6 Course")
#在上方的菜单栏添加
window.menuBar().addMenu("File")

window.show()


#执行应用程序
sys.exit(app.exex())


#在PyQt5则可以这样子：app.exec_()
```





### QDialog

对话窗口的基类，对话窗口是顶级窗口，主要用于短期任务和用户的简短交流，QDialog可能是模型也可能是无模式的

没有最大化和最小化按钮

```Python
from PyQt6.QtWidgets import QApplication, QDialog
import sys
#app = QApplication([])
app = QApplication(sys.argv)

#创建窗口对象
window = QDialog()

window.show()


#执行应用程序
sys.exit(app.exex())


#在PyQt5则可以这样子：app.exec_()
```





### 单选按钮

QRadioButton，是QtWidgets模块中的 

我有点不太理解的就是这些按钮是怎么知道是同一组的？是通过布局吗？

```Python
def create_radio(self):
    hbox = QHBoxLayout()
    
    rad1 = QRadioButton("Python")
    rad1.setIcon(QIcon())
    rad1.setIconSize(QSize(40, 40))
    rad1.setFont(QFont("Times", 14))
    rad1.setChecked(True) #默认选中
    #切换，普通按钮则是点击
    rad1.toggled.connect(self.radio_selected)
    
    rad2 = QRadioButton("Java")
    rad2.setIcon(QIcon())
    rad2.setIconSize(QSize(40, 40))
    rad2.setFont(QFont("Times", 14))
    rad2.toggled.connect(self.radio_selected)

    
    self.label = QLabel("")
    self.label.setFont(QFont("Sanserif", 15))
    
    vbox = QVBoxLayout()
    vbox.addWidget(self.label)
    vbox.addLayout(hbox)
    
    hbox.addWidget(rad1)
    hbox.addWidget(rad2)
    
    
    #self.setLayout(hbox)
    #主界面切换成vbox
    self.setLayout(vbox)
    
def radio_selected(self):
    #从单选按钮中获取值
    radio_btn = self.sender()
    if radio_btn.isChecked():
        self.label.setText(f"You have selected:{radio_btn.text()}")
```

按钮分组

```Python
def radio_selected(self):
    selected1 = ""
    selected2 = ""
    if self.radioButton_py.isChecked() == True:
        selected1 = "Python"
    if self.radioButton_java.isChecked() == True:
        selected1 = "Java"
    if self.radioButton_js.isChecked() == True:
        selected1 = "JavaScript"
        
        
    if self.radioButton_test1.isChecked() == True:
        selected2 = "test1"
    if self.radioButton_.test2isChecked() == True:
        selected2 = "test2"
    if self.radioButton_test3.isChecked() == True:
        selected2 = "test3"
    self.label_result.setText("Chosen Book" + selected)
```



### 多选按钮

QcheckBox类

可以通过isChecked() 查询复选框是否被选中

self.check1 = QCheckBox("Python")

跟单选按钮基本是一样的





QMainWindow提供了很多标准的窗口功能

我们把它们弄成一个类，然后再去设置一些小组件会简单很多

QMainWindow有setCentralWidget(组件)方法

意思是把组件A到QMainWindow上，默认会占据整个窗口





按钮的 .setCheckable 是什么意思呢？

clicked 和 toggeld 这两个信号有什么区别呢？



button的setChecked 是什么意思呢？



button.isChecked() 获取按钮的状态



button还有一个released信号，但没法发送状态，如果使用released然后想获取状态的话只能通过 button.isChecked()





窗口的信号：.windowTitleChanged

如果设置的标题跟原来的一样，则信号不会被触发	

```python
#接收窗口的状态
def the_window_title_changed(self, window_title):
    print("Window title changed: %s" % window_title)
```









```python
#接收按钮的状态
def the_button_was_toggled(self, checked):
    self.button_is_checked = checked
```



self.input.textChanged.connect(self.label.setText) 

编辑框中文本改变后直接将label里面的文本设置为编辑框中文本





\#修改标签字体

​    self.plainTextEdit.setFont(myFont)

## 气泡提示

```python
element.setToolTip("这里面可以输入富文本内容")
```

## 系统建议的尺寸

```python
btn.resize(btn.sizeHint())
```

大多数小部件都有父级。没有父级的小部件的父级是顶级窗口。

## 退出应用程序的方法

可以把它连接到信号上

```python
QApplication.instance().quit
```

## 弹窗

关闭 `QWidget` 操作会产生 `QCloseEvent` 事件。重新实现 `closeEvent` 事件处理，替换部件的默认行为。

closeEvent方法是弹窗本来就有的，我们只是进行重写，因此，不需要进行信号连接

```python
def closeEvent(self, event):

    reply = QMessageBox.question(self, 'Message',
                                 "Are you sure to quit?", QMessageBox.StandardButton.Yes |
                                 QMessageBox.StandardButton.No, QMessageBox.StandardButton.No)

    if reply == QMessageBox.StandardButton.Yes:

        event.accept()
    else:

        event.ignore()
```

## 窗口居中

想让窗口在屏幕居中的话我们调用这个方法就行了

```python
 def center(self):
		
        #得到一个矩形的窗口，这里可以放置所有类型的窗口
        qr = self.frameGeometry()
        
        cp = self.screen().availableGeometry().center()

        #从屏幕属性里计算出分辨率，然后计算出中心点的位置
        qr.moveCenter(cp)
        
        #我们已经知道矩形窗口的宽高，只需要把矩形窗口的中心点放置到屏幕窗口的中心点即可。这不会修改矩形窗口的大小。
        #把应用窗口的左上方点坐标移动到矩形窗口的左上方，这样就可以居中显示了
        self.move(qr.topLeft())
```

## QMainWindow

提供了主程序窗口，可以创建具有状态栏，工具栏和菜单栏的应用程序

## 创建状态栏

```python
#只有QMainWindow可以创建
element.statusBar().showMessage('Ready')
#添加组件
element.statusBar().addWidget('Hello')
```

## 创建菜单栏

```python
#QAction 是行为抽象类，包括菜单栏，工具栏，或自定义键盘快捷方式。在上面的三行中，创建了一个带有特定图标和 'Exit' 标签的行为
#创建一个行为
exitAct = QAction(QIcon('exit.png'), '&Exit', self)
#绑定快捷方式
exitAct.setShortcut('Ctrl+Q')
#鼠标悬停就会显示的东西
exitAct.setStatusTip('Exit application')
#绑定点击事件
exitAct.triggered.connect(QApplication.instance().quit)

#创建菜单栏
menubar = self.menuBar()

#创建菜单的时候为什么需要搞一个self呢？都有菜单栏去添加它了
#菜单的所有组件好像都需要添加self
#添加菜单栏下的选项
fileMenu = menubar.addMenu('File')

#创建一级菜单
menu_father = QMenu("Hello", self)

#创建二级菜单
menu_son = QMenu("World", self)

#创建动作
new = QAction("你好世界", self)

#将一级菜单添加到选项中
fileMenu.addMenu(menu_father)

#将二级菜单添加到一级菜单中
menu_father.addMenu(menu_son)
menu_son.addAction(new)
```











# 日期和时间

QDate：处理公历中的日期

QTime：处理时间

QDateTime：二者的组合

## 获取当前时间

三个类都可以，这是类中的静态方法

```python
QDate.currentDate()
QTime.currentTime()
QDateTime.currentDateTime()
```

打印出来的结果是这样的

```python
PyQt6.QtCore.QDate(2023, 1, 12)
PyQt6.QtCore.QDateTime(2023, 1, 12, 18, 41, 31, 520)
PyQt6.QtCore.QTime(18, 41, 31, 520)
```

使用 .toString() 可以转化为便于观看的字符串

`Qt.DateFormat.ISODate` 和 `Qt.DateFormat.RFC2822Date` 获取不同格式的日期。

## 标准时间

QDateTime.currentDateTime().toUTC().toString()

与标准时间的差，秒为单位

QDateTime.currentDateTime().offsetFromUtc()

## 构造一个时间，日期

```python
d = QDate(1945, 2, 2)
t = QTime(20, 2, 2)
dt = QDateTime(1945, 2, 2, 20, 2, 2)
print(d.toString())
```

## 获取特定年份，月份

```python
d = QDate(1945, 5, 8)
print(d.daysInYear())
print(d.daysInMonth())
```

## 天数差

后 - 前

```python
print(QDate.currentDate().daysTo(QDate(1924, 2, 2)))
```

## 时间的计算

里面可以填负数，返回的是QDateTime类

好像所有方法返回的都是QDateTime类，最后都需要转换成字符串

```python
now = QDateTime.currentDateTime()
print(now.addDays(10))
print(now.addYears(100))
print(now.addMonths(100))
print(now.addSecs(100))
print(now.addMSecs(100))
```



python中的random模块，choice(列表)

python中取绝对值 abs

# 多线程

拷贝文件

```Python
import multiprocessing
import os
def copy_file(file_name, source_dir, dest_dir):
    source_path = source_dir + '/' + file_name
    dest_path = dest_dir + '/' + file_name
    with open(source_path, "rb") as source_file:
        with open(dest_path, "wb") as dest_file:
            while True:
                data = source_file.read(1024)
                if data:
                    dest_file.write(data)
                else:
                    break
if __name__ == '__main__':
    source_dir = "C:/Users/27208/Desktop/笔记"
    dest_dir = "D:"
    try:
        os.mkdir(dest_dir)
    except:
        print("目标文件夹已经存在！")
    file_list = os.listdir(source_dir) #可以得到所有的列表信息

    #遍历所有文件进行拷贝
    for file_name in file_list:
        sub_process = multiprocessing.Process(target=copy_file,
                                              args=(file_name, source_dir, dest_dir))
        sub_process.start()

```

![image-20230106193112341](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106193112341.png)

![image-20230106193133375](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106193133375.png)

![image-20230106193206365](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106193206365.png)

![image-20230106193226478](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106193226478.png)

线程传参数跟进程是一样的

注意传元组的时候记得要加逗号

主线程也会等所有的子线程结束之后才结束，如果想要主线程结束的话子线程就销毁可以设置守护主线程

![image-20230106194015090](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106194015090.png)

![image-20230106194151334](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106194151334.png)

![image-20230106194445336](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106194445336.png)

![image-20230106194454742](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106194454742.png)

![image-20230106194507781](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230106194507781.png)

# 如何保持注意力

不要连续醒着超过六个小时

不要连续工作超过一个小时

不要连续一天都在接触同一个工作 / 技术

# 习惯养成

按照使用方式，最有利于高效的方式去分类

让做这件事情的阻力变得最小

让自己清楚每一步需要做什么



# 手机布局

- 出行：高德地图，车来了，携程旅行，12306，哈喽，乘车码
- 购物：美团，饿了么，闲鱼，京东，淘宝，拼多多，菜鸟裹裹
- 学校：易班，学习通，完美校园，大学搜题酱，企业微信，好策，学小易，腾讯会议，知到，钉钉
- 娱乐：王牌战士，王者荣耀，哔哩哔哩，知乎，QQ音乐，网易云音乐，崩坏3，原神，NBA，腾讯体育，虎扑，虎牙
- 理财：农业银行，建设银行，支付宝，有钱花，一本记账
- 学习：微信读书，kindle阅读，网易公开课，百词斩，不背单词
- 工具：侠客工具箱，不做手机控，夸克，美图秀秀，MissLee，中国移动广东，百度网盘，阿里云盘，讯飞输入法，全能计算器
- 生活：丁香医生，Keep，下厨房，倒数321，柠檬小月，15日天气预报，时光相册，吾记日记，Moon月球，地球和月球3D，
- 小鹅通，CCTalk，flowus，滴答清单，元气桌面壁纸 
- 小组件：日记，待办，余额，今年已过，天气，倒数日，月球，丁香医生，恋爱日

# 电脑布局

- 阅读工具：WPS（Koodo Reader，悦书，Neat Reader，）
- 梯子：CS自学指南，芝麻加速
- 远程协作：ToDesk，uu远程
- 桌面：元气桌面，rainmeter
- 效率工具：boardmix，everything，滴答清单，Xmind，Flowus,  Typora
- 百度云盘，阿里云盘
- 开发工具：VS，VSCode，MySQL，PyCharm，designer，idea，Cisco Packet Tracer
- 网易云，有道云翻译，腾讯会议，火绒，QQ，微信，Chrome，Edge
- 游戏：原神，QQ飞车

# 学习跟日常生活没有两样

我对学习的理解很简单，就是去探索，去满足自己的好奇心，去实现自己做的东西

我们在讨论如何学习的时候，先不要忘了，我们为什么要学习呢？

是为了分数，为了工作，还是单纯好奇，想做一些好玩的东西

比方说，现在我们想要学习Java，但是也不要马上急着开始学习？

可以先停下来想想，我为什么要学习Java呢？

噢，是为了找工作，是因为我想要一份好工作，可以让我过上更好的生活，除此之外，我还可以用Java来做一些有趣的事情，比如开发一些好玩的网站， 那肯定很有趣

接下来继续拓展你的思维，你可能会想：欸那这样的话我就可以自己开发一些有趣的功能来解决我平时写日记的问题，还有写博客的问题，我喜欢写博客，但是我一直苦于没有好的网站，如果能自己做一个网站那绝对是一件很酷的事情，那这样的话我可以给自己的网站设置任意我界面还有功能，只要我喜欢的话，还有我可以......

当我们开始思考学习的原因时，自然而然就知道从何开始了，从目的出发，我想要找工作，以及自己做一些网站或是软件

首先，是去看看Java开发岗位有什么样的要求，或是要让自己明白做网站，软件，需要什么技能？

可以去搜索引擎，或是各种论坛，只要最后我们能明确知道Java开发的工作需要学习什么样的内容即可

你也可以先自己思考，探索，比方说，想想网站是由什么东西构成的

接着你可以去观察你上过的一些网站，去思考，网站上的每一个图标，图片，文字是怎么显示到屏幕上的，再深一点，你或许会觉得这是一件非常不可思议的事情，我只要按几下键盘，点几下鼠标就能操纵一台电脑，搁以前来看那妥妥的魔法师啊

你会对这些事情感到好奇，感到不可思议，会想要探索，弄明白，这是非常自然而然的事情，就像婴儿看到不一样的玩具总会想去摆弄几下，看看时针是怎么转动的，车子是怎么行驶的一样

接下来，你就可以继续往下探索，现在你已经不仅仅满足于找一份工作以及做出一个网站了，你还想要理解面前这台古怪，死板而又神奇的机器

会想知道为啥相隔千里的相同的古怪机器能够互相知道对方在干什么，会想知道移动鼠标是怎么带动屏幕前的白色小手了......

接下来，你就可以去寻找一些教程，书籍，开始在计算机的大海里遨游了

其实我们的学习，就跟前面我们在探索计算机的过程是一样的

比方说，我们学到`Java`语法中的数据类型

那很自然地，我们就会有疑惑，为啥要分这么多数据类型呢？既然变量分这么多数据类型是为了表示我们生活中的各种事务，那生活中出现最多的就是人了，那能不能搞一个人的数据类型呢？或者再多增加一些别的数据类型出来呢？

接着，就像前面一样，我们可以通过任何方式，去找到答案或者相关的内容，搜索引擎，老师同学，自己思考等等

那其实这个过程就跟前面你对鼠标，键盘就能操控电脑的不解或者对日常生活的疑惑是一样的，没有什么神奇的

当然，学习的过程除了这些疑惑之外，你还需要去认识许多新鲜的事物，但这仍然跟你日常生活接触任何新鲜事物没有两样，仅仅是难度不同

因此，不要把学习这件事当成是什么了不起的，高高在上的事情，要先卸下对学习的恐惧

# 我总是写不好笔记

我是这样记笔记的，有一个叫缓冲区的.md文件

平时我在看任何课程，笔记，书籍时



选中所有标签，一般去除默认的padding和margin

*{	

​	margin: 0;

​	padding: 0;

}		



# 谷歌调试器

黄色三角则说明语法错误

删除线则代表覆盖或注释







# Emmet语法

快速生成代码

div,  .red,  #one,  ul>li,  ul>li{}, ul>l*3, p.red#one

从1开始生成数字ul>li{$}*3

background-color可以写成bgc，写单词的首字母就行了

写CSS代码时使用加号，w300+h200+bgc就可以直接生成代码

# VSCode

F2的用法

# HTML嵌套规范注意点

a标签可以嵌套任何标签，但不能嵌套a标签

p标签中不要嵌套div，p，h等块级标签



选择器优先级

优先级

![image-20230119085242637](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230119085242637.png)

权重叠加计算

![image-20230119085643857](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230119085643857.png)

![image-20230119090540729](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230119090540729.png)

如果右边元素没有，一般就是选择器写错了

CSS上一行出错，会导致下一行也失效

# 设置margin之后好像就没法设置行内块了

```python
you-get url
from moviepy.editor import AudioFileClip
my_audio_clip = AudioFileClip("e:/chrome/my_video.mp4")
my_audio_clip.write_audiofile("e:/chrome/my_audio.wav")
```



# 下载字体

```html
<link href="https://fonts.font.im/css?family=Open+Sans" rel="stylesheet" type="text/css">
```



# 图像居中

```css
img {
	display: block;
	margin: 0 auto;
}
```





# js

## Finding HTML elements

id, tag name, class name, CSS selector, HTML object collections	

返回的对象中，可以使用innerHTML 还有 innerText	

![image-20230129184038490](C:\Users\27208\AppData\Roaming\Typora\typora-user-images\image-20230129184038490.png)







事件处理函数中的事件对象（e.target:  刚刚发生的元素的引用）

其他事件概念：事件对象，阻止默认事情，事件冒泡及捕获，事件委托

事件：obsumit（e.preventDefault())，可以阻止默认事件

事件处理：事件处理器属性，内联事件处理器和addEventListener（），可以添加多个事情

添加事件：addEventListener('event', function)  和

```
myElement.onclick = functionA;
myElement.onclick = functionB;
```

removeEventListener()

document 里的，创建元素，createElement

setText：textContent，innerHTML

选中元素，querySelector, querySelectorAll，getElementById

插入元素：appendChlid, removeChild

修改样式：style

修改属性：Element.setAttribute("class", "messageBox")

尽可能多地使用let

事件：onclick

点击鼠标，悬停光标，键盘，调整浏览器大小或关闭窗口，停止加载，提交表单，播放，暂停，关闭视频，发生错误

btn.onfoucs 

btn.onblur

btn.ondbclick

window.onkeypress

window.onkeydown

window.onkeyup

btn.onmouseover

btn.onmouseout

video.onplay



变量类型：Number,  String, Boolean,  Array, Object

# 



# 浏览器API

浏览器API：DOM API,  Geolocation API, Cavas, WebGL API, HTMLMediaElement 等API

第三方API



javascript 数组中的 includes， join,  push, pop, unshift, shift

字符串, length, indexOf, slice, toLowerCase(), toUpperCase(), replace, split

# 堉霞的文章

昨天晚上为什么会晚睡觉呢？其实自己去厕所洗澡泡脚好了，但是还是很不开心，在玩着手机，逃避着什么东西，刷着小红书说00后日赚多少多少，还有一个艺术博主在做一个什么实验，我到底在干什么，以这种态度对待自己的生活吗，其实也没什么大不了的





如果还是跟以前的目标那样子，设置目标再完成会让人一下子就放弃的，而且我自己的话可信度也不高，常常下很高的口号再不要脸的放弃。



好像之前看家涛推荐的网站里面有一篇文章，好像有目标管理，时间管理，我去看看笔记



要不要按照那个方法来尝试一下，刚好我有家涛这监督人



为什么我会不去看这mtsql？



一是因为我觉得好麻烦，MySQL需要打开外网很多时候需要我去打开再关闭打开再关闭，耗费的时间精力足以让我放弃学习



二是自己根本没有去打开电脑，就像今天，如果没有家涛强制性叫我起床，我会习惯性下高目标，下明明未来的自己就没办法去完成的任务来给当下的自己继续懒散，继续留在舒适区，尽管这个舒适区让我很不舒服



三是自己还是很害怕“学习”，害怕自己又像个小孩子一样牙牙学语，我还是不愿意承认自己很拉的事实，明明就不懂，咦，我就是不管，就是不承认，只要跳过，只要不去接触，只要不去打开，咦，我就不会知道我不懂了。



四是好尴尬啊，好多次学习的时候害怕被老弟老妹他们看到，我都不敢念出声读英语，只在默默脑子里默念，因为如果被他们知道如果我连一到十的英语单词还要拿手指念的话，实在是没有脸了



分析好原因之后，再来看一个一个问题如何去解决，目的是为了去达成目标，更好的去学习MySQL等知识



第一个可以在又连外网的情况下，提前打开MySQL的页面，提前加载好，这样即使关闭网络也是可以看的



第二个就是诱惑自己，先打开笔记本，然后打开网址，就这样就好了，因为很多时候我连打开笔记本都不愿意，可以学家涛一直打开笔记本，然后就省下了打开笔记本这个步骤，每次不要给自己下太高的目标







博客也是一样的道理，如果我每次都要限定就要写多少多少字，这样我脑子里会一直想那个问题，然后不去思考我到底要如何去写去表达



比如像这次，我没有限制自己要达到多少目标的字，我反倒轻松自在，还真正去分析原因，因为自己只要动起来就肯定不会说写不出来。



他好傻逼，我不可以在小红书上面发嘛



那我要重新去复习一下那些HTML了，因为我都忘记那些基本的语法是怎么写的了。



难道家涛是在写代码的软件上面写的文章的？那不是好low吗，网站不是可以设置输入的吗？



还有可以插入图片什么的，不然我们一直在网上写的说说和朋友圈是怎么发的？



难道他真的是用代码软件写文章？？？



# 基于form表单构造HTTP请求



# Tomcat使用

- 要想运行，得能够找到JDK
  - 直接将.bat拖动到CMD中
  - 手动配置环境变量
- 修改端口号：config -- server.xml
  - netstat -an | findstr 8080查看谁占用了8080
- 日志：logs



# Maven使用

- 创建项目
- 目录结构
- 打包
- 下载并安装第三方库
  - 去中央仓库找
  - 把Maven XML配置放到pom.xml中的dependencies中
  - 如果没有下载就刷新一下
- 将Maven仓库配置成使用国内的源
  - 将maven源改为国内阿里云镜像
  - 从Build -- Build Tools -- maven 中勾选掉 User setting file中的Override然后将更换源的配置放到pom.xml中

























