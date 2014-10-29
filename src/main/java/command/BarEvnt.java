package command;

/**
 * Created by mds on 01/10/14.
 */
public class BarEvnt implements Command {

	InvokerEvent controler;

	 @override
	public void execute() {
		this.controler.barEvnt();
		
	}
	public BarEvnt(InvokerEvent pControler) {
		this.controler = pControler;
	}
}
