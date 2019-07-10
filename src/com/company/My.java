package com.company;

class My extends MyListImpl<String> {
    @Override
    public void add(String e) {
        super.addSome(e);
    }
}
