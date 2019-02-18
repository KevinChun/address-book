package pe.kevin.exam.guntreeuk;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */
public enum Gender {
    Male,
    Female;

    public Gender findByVal(String val){
        return Gender.valueOf(val);
    }
}
