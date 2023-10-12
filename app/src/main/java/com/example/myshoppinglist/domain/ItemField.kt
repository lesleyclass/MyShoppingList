package com.example.myshoppinglist.domain

internal sealed class ItemField{
    abstract val value: String?

    class Name(override val value: String?) : ItemField()
    class Value(override val value: String?) : ItemField()
    class Quantity(override val value: String?) : ItemField()
    class TotalValue(override val value: String?) : ItemField()
    class Description(override val value: String?) : ItemField()
}