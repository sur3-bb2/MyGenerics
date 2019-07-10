package com.company;

class MyClass {
    <T extends String> T addSome(T some) {
        return (T) ("Some " + some);
    }
}
