package hllo;
class HexToBinary{
//char[]  hexCode = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E' ,'F'};
//
//public String toHexBinary(byte[] data){
//    StringBuilder r = new StringBuilder();
//    for(byte b :data) {
//        r.append(hexCode[(b.toInt() shr 4) and 0xF])
//        r.append(hexCode[b.toInt() and 0xF])
//    }
//    return r.toString()
//}
	
	public static void ByteToString(byte[] bytes) {
		{   StringBuilder st=new StringBuilder();
	        //byte[] bytes = {10, 2, 15, 11};
	        for (byte b : bytes) {
	            st = st.append(String.format("%02X", b));
	            
	        }
	       // return st;
	        System.out.print(st.t);
	    }
	}
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	public static void main(String[] args) {
		String templateMsg="30323030F23A448108E0800000000000040001003139323232323030313030383838383838383838383930303030303030303030303031303030303032303632303031323338353536363731333233333530323036313031373438313430313930353036313131313131303933373133323333353130444E423538383536444E4239313938363535353838353653415244415220524F41442020202020202020202020204D41445241532020202020202020494E203335363131323232323232323232323231313730303130303234383030323030334D4F4230343530303753686976616E6930343930303334373530353030313931313131303031303039393939393939393939303531303034544553543035363030334D4F4230353930313148444643363430373735333036323031313232323232323232323232";
		System.out.println(hexStringToByteArray(templateMsg).toString());
		ByteToString(hexStringToByteArray(templateMsg));
	}
	
}