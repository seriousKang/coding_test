package leetcode.easy;

public class DefangingAnIPAddress {
	public String defangIPaddr(String address) {
        String result = address.replace(".", "[.]");
        
        return result;
    }
}
