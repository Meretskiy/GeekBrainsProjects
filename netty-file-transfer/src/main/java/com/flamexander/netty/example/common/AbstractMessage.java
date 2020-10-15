package com.flamexander.netty.example.common;

import java.io.Serializable;

/*
    Сериализуемый абстрактный класс сообщений,
    любым из них можно обмениваться между сервером и клиентом.
 */
public abstract class AbstractMessage implements Serializable {
}