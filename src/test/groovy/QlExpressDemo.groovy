import com.ql.util.express.DefaultContext
import com.ql.util.express.ExpressRunner

class QlExpressDemo {

    interface Statement {
        String content()
    }

    class Reduce implements Statement {
        def value = 1

        @Override
        String content() {
            """n=n-${value};"""
        }

        Reduce(value) {
            this.value = value
        }
    }

    class To implements Statement {
        def value = 30

        @Override
        String content() {
            """n=${value};"""
        }

        To(value) {
            this.value = value
        }
    }

    class Over implements Statement {
        def value = 30

        @Override
        String content() {
            """if(n>${value})"""
        }

        Over(value) {
            this.value = value
        }
    }

    class Less implements Statement {
        def value = 30

        @Override
        String content() {
            """if(n<${value})"""
        }
    }

    class Res implements Statement {
        @Override
        String content() {
            """return n;"""
        }
    }

    String getScript() {
        def actions = [
                new To(42),
                new Over(40),
                new Reduce(5),
                new To(30),
                new Res()
        ]
        def script = ""
        actions.each {
            script += it.content()
        }
        println(script)
        script
    }

    static void main(String[] args) {
        def runner = new ExpressRunner()
        QlExpressDemo demo = new QlExpressDemo()
        def script = demo.getScript()
        def res = runner.execute(script, new DefaultContext<String, Object>(), null, true, true)
        println("结果：" + res)
    }

}
