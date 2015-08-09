package utility;

public enum TypeElement {
//,"LINK_TEXT"
	ID("ID"),
	NAME("NAME"),
	XPATH("XPATH"),
	LINKTEXT("LINKTEXT"),
	CSSSELECTOR("CSSSELECTOR"),
	TAGNAME("TAGNAME"),
	PARTIALLINKTEXT("PARTIALLINKTEXT"),
	CLASSNAME("CLASSNAME"),
	BYCLASSNAME("BYCLASSNAME"),
	BYID("BYID"),
	BYCSSSELECTOR("BYCSSSELECTOR"),
	BYLINKTEXT("BYLINKTEXT"),
	BYNAME("BYNAME"),
	BYTAGNAME("BYTAGNAME"),
	BYXPATH("BYXPATH");
	
	private String value;
	TypeElement(String value)
	{
		this.value=value;
	}
	/*TypeElement(String value,String  value2 )
	{
		this.value=value;
	}*/

	public String getValue()
	{
		return value;
	}
	public static TypeElement fromString(String  val)
	{
		if(val!=null){
			for(TypeElement e:TypeElement.values()){
				if(val.equalsIgnoreCase(e.value))
				{
					return e;
				}
			}
		}
		return null;
	}
	
}
