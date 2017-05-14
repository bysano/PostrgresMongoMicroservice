package by.user.domain;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by alka0317 on 4/26/2017.
 */
@StaticMetamodel(User.class)
public class User_ {
    public static volatile SingularAttribute<User,Long> id;
    public static volatile SingularAttribute<User,String> name;
    public static volatile SingularAttribute<User,String> surname;
}
