package com.example.customgallerypicker

import com.airbnb.epoxy.EpoxyAdapter

class Adapter(list:List<DummyObject>): EpoxyAdapter() {
    init {
        list.forEach {
            addModel(BodyItemModel_(it))
        }
    }
}