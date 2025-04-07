package com.example.lab3;

import java.util.LinkedList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StringList extends LinkedList<String>
{
    @Inject
    StringList()
    {
    }
}