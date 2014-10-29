package command;

/**
 * Created by mds on 01/10/14.
 */
public class BeetEvnt implements Command{
	InvokerEvent controler;
	
	
	@override
	public void execute() {
		this.controler.beetEvnt();
		
	}
	public BeetEvnt(InvokerEvent pControler) {
		this.controler = pControler;
	}

}
