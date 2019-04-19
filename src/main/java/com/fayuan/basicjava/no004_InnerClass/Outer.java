package com.fayuan.basicjava.no004_InnerClass;

class Outer {

        private Inner inner;

        public Outer() {
        }

        class Inner {
            public Inner() {}
        }

        /**
         * 内部类的单例
         *
         * @return 单例
         * */
        public Inner getInnerInstance() {
            if (null == inner) {
                inner = new Inner();
            }
            return inner;
        }
    }