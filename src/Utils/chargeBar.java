package Utils;

import javax.swing.JLabel;

import Vista.frmPrincipal;
import Vista.logoStart;

public class chargeBar implements Runnable{
	private JLabel label;
	private logoStart ls;

	public chargeBar(JLabel label, logoStart ls) {
		
		this.label = label;
		this.ls = ls;
	}


	@Override
	public void run() {
		int num = 0;
		for (int i=0; i<100; i++) {
			num +=1;
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			label.setText(num+"%");
		}
		frmPrincipal principal = new frmPrincipal();
		principal.setVisible(true);
		ls.dispose();
		
	}

}
