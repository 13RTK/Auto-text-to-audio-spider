# 1.概述
- 该项目意在实现一个从网络爬取小说内容，并将文本文件转换为音频文件的工具
- 该项目的音频转换功能依赖于Azure的语言服务，如果需要自行编译构建，请自备一个Azure的开发密钥，并替换掉resources目录下的"azure.properties"文件中speech.key的值<Your-Azure-Resource-Key>

# 2. 运行
- windows用户请在releases中的云盘链接内下载对应的文件，链接中有两个文件，全部下载后点击运行其中的exe文件即可，另一个文件请不要删除，否则无法运行（依赖的JDK）
- mac用户请自备jdk后，下载jar包运行（mac打包在学了>_<）

# 3. 文档
- [Azure文本转语音入门文档](https://learn.microsoft.com/zh-cn/azure/cognitive-services/speech-service/get-started-text-to-speech?tabs=windows%2Cterminal&pivots=programming-language-java)
- [Azure文本合成语音参考文档](https://learn.microsoft.com/zh-cn/azure/cognitive-services/speech-service/how-to-speech-synthesis?tabs=browserjs%2Cterminal&pivots=programming-language-java#synthesize-speech-to-a-file)
- [语音服务支持区域对照表](https://learn.microsoft.com/zh-cn/azure/cognitive-services/speech-service/regions) （需要与自己Azure里的资源区域一致，用于配置项目中的speech.region）
- [语音服务的语言和声音支持对照表](https://learn.microsoft.com/zh-cn/azure/cognitive-services/speech-service/language-support?tabs=stt-tts#prebuilt-neural-voices)
- [音频格式对照表](https://learn.microsoft.com/zh-cn/dotnet/api/microsoft.cognitiveservices.speech.speechsynthesisoutputformat?view=azure-dotnet)