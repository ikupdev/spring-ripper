package ru.kuper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Ilya V. Kupriyanov
 * @version 10.03.2022
 * Все методы, которые аннотированы PostProxy запускаются сами в момент, когда все настроено и все прокси настроились
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PostProxy {

}
