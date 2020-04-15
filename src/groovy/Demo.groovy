package groovy

class Demo {
    static void main(args) {
        //"Hello World"
        println "Hello World"

        // Groovy 是没有类型的 Java 代码
        def msg = "Hello World"
        println "msg.class is " + msg.class
        def age = 12
        print age.class

        repeat("Hello World")
        repeatWithDefault("Hello", 2)
        repeatWithDefault("Good Sunshine", 4)
        repeatWithDefault("World")

        testCollention()
        testHash()
        testClosure()

        // 引用Groovy类
        def song = new Song(name: "Le Freak", artist: "Chic", genre: "Disco")
        def sng2 = new Song(name:"Kung Fu Fighting", genre:"Disco")
        def sng3 = new Song()
        sng3.name = "Funkytown"
        sng3.artist = "Lipps Inc."
        sng3.setGenre("Disco")

        assert sng3.getArtist() == "Lipps Inc."
        println sng3

        sng2.artist?.toUpperCase()
    }

    // 通过 Groovy 进行循环
    static def repeat(val) {
        // 1.
        /*for(def i=0; i<5; i++){
            println val
        }*/

        //2.
        for (i in 0..<5) {
            println(val)
        }
    }

    // 默认参数值
    static def repeatWithDefault(val, repeat = 5) {
        for (i in 0..<repeat) {
            println val
        }
    }

    // Groovy 集合
    static def testCollention() {
        def range = 0..4
        println range.class
        assert range instanceof List

        def coll = ["Java", "Python", "Groovy"]
        assert coll instanceof Collection
        // 添加项
        coll.add("Ruby")
        coll << "Smalltalk"
        coll[5] = "Scala"
        // 检索非常轻松
        println coll[4]

        assert coll + "JS" == ["Java", "Python", "Groovy", "Ruby", "Smalltalk", "Scala", "JS"]
        assert coll - ["Python", "Groovy", "Ruby", "Smalltalk", "Scala", "JS"] == ["Java"]

        // 魔法方法
        assert [1, 2, 3, 4].join(",") == "1,2,3,4"
        assert coll.count("Java") == 1
    }

    static def testHash() {
        def hash = [name: "Allen", "age": 45]
        println(hash.getClass())
        hash.put("id", 1)
        println(hash.get("name"))
        hash.dob = "01/29/76"
        hash["gender"] = "male"
        assert hash.gender == "male"
        assert hash["gender"] == "male"
    }

    static def testClosure() {
        def acoll = ["Groovy", "Java", "Ruby"]

/*        for(Iterator iter = acoll.iterator(); iter.hasNext();){
            println iter.next()
        }*/

        acoll.each {
            println it
        }

        acoll.each { value ->
            println value
        }

        def hash = [name: "Andy", "VPN-#": 45]
        hash.each { key, value ->
            println "${key} : ${value}"
        }
    }
}
