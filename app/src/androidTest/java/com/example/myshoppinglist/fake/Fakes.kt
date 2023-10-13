package com.example.myshoppinglist.fake

import io.github.serpro69.kfaker.Faker

private val faker = Faker()

internal fun randomName(): String = faker.company.name()
internal fun randomInt(min: Int = 0, max: Int = 10): Int = faker.random.nextInt(min = min, max = max)
internal fun randomDouble(): Double = faker.random.nextDouble()
internal fun randomMessage(): String = faker.lorem.words()
internal fun randomTitle(): String = faker.company.name()