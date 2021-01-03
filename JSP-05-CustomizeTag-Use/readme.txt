如何打包自定义标签库?
1.实现SimpleTag接口/SimpleTagSupport类，重写doTag()方法。

2.编写标签库描述符（tld）文件，在tld文件中对自定义标签进行描述，并放置在WEB-INF/目录下。
(如果需要打包的话，在src/下建META-INF文件夹，将tld文件放在该文件夹下)

3.完成以上操作，即可在JSP页面中导入和使用自定义标签。