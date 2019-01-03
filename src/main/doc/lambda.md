#3.3 常用流操作
    -[1] collect(toList())
    使用collect(toList())方法从Stream中生成一个列表，
    由于很多Stream操作是惰性求值，所以调用Stream的方法之后，还需要最后调用
    一个类似collect的及早求值方法。
    -[2] map
    map可以将一个流中的值转换成一个新的流。
    -[3] filter
    遍历数据并检查其中的元素
    -[4] flatMap
    使用stream方法，将每个列表转换为Stream对象，其余部分由flatMap方法处理。
    flatMap方法的相关函数接口和map方法一致，都是Function接口，只是方法的返回
    限定为Stream类型。
    -[5] min&max
    查找Stream中的最大或最小元素。
    