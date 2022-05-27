/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package lambdas.java8FunctionalProgramming.stream.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 艺术家
 *
 * @author fzw.fzw
 * @version $Id: Artist.java, v 0.1 2018年10月21日 上午10:52 fzw.fzw Exp $
 */
public class Artist {

    /** 名字 */
    private String name;

    /** 成员 */
    private List<Artist> members;

    /** 国籍 */
    private String nationality;

    public Artist(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Artist(String name, List<Artist> members, String nationality) {
        this.name = name;
        this.members = members;
        this.nationality = nationality;
    }

    public boolean isForm(String city) {
        return false;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for property <tt>members</tt>.
     *
     * @param members value to be assigned to property members
     */
    public void setMembers(List<Artist> members) {
        this.members = members;
    }

    /**
     * Getter method for property <tt>nationality</tt>.
     *
     * @return property value of nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Setter method for property <tt>nationality</tt>.
     *
     * @param nationality value to be assigned to property nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Stream<Artist> getMembers() {
        return members.stream();
    }

    public boolean isSolo() {
        return members.isEmpty();
    }

    public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(Collectors.toList());
        return new Artist(name, members, nationality);
    }

    @Override
    public String toString() {
        return getName();
    }
}