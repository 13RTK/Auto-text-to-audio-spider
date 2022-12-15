# 1.概述
- 该项目意在实现一个从网络爬取小说内容，并将文本文件转换为音频文件的工具
- 该项目的音频转换功能依赖于Azure的语言服务，请自备一个Azure的开发密钥（该功能开发中）

# 2. 运行
- 该项目运行需要Java环境，请在releases中下载jar文件后，通过java -jar命令运行:
```java
java -jar <.jar文件的绝对路径>
```

# 3. 文档
- [Azure文本转语言入门文档](https://learn.microsoft.com/zh-cn/azure/cognitive-services/speech-service/get-started-text-to-speech?tabs=windows%2Cterminal&pivots=programming-language-java)
- [Azure文本合成语音参考文档](https://learn.microsoft.com/zh-cn/azure/cognitive-services/speech-service/how-to-speech-synthesis?tabs=browserjs%2Cterminal&pivots=programming-language-java#synthesize-speech-to-a-file)
- [语言服务支持区域对照表](https://learn.microsoft.com/zh-cn/azure/cognitive-services/speech-service/regions) （需要与自己Azure里的资源区域一致，用于配置项目中的speech.region）
- [语言和声音支持对照表](https://learn.microsoft.com/zh-cn/azure/cognitive-services/speech-service/language-support?tabs=stt-tts#prebuilt-neural-voices)
- [音频格式对照表](https://learn.microsoft.com/zh-cn/dotnet/api/microsoft.cognitiveservices.speech.speechsynthesisoutputformat?view=azure-dotnet)