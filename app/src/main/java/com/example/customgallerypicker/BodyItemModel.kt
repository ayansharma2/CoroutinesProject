package com.example.customgallerypicker

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass
abstract class BodyItemModel(var dummyObject: DummyObject):EpoxyModelWithHolder<BodyItemModel.Holder>() {
    override fun getDefaultLayout(): Int {
        return R.layout.item
    }

    override fun bind(holder: Holder) {
        holder.id.text=dummyObject.id
        holder.title.text=dummyObject.title
    }


    class Holder:EpoxyHolder(){
        lateinit var id:TextView
        lateinit var title:TextView
        override fun bindView(itemView: View) {
            id=itemView.findViewById(R.id.id)
            title=itemView.findViewById(R.id.title)
        }

    }
}