package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import FrameworkClasses.Utilities;

public class Listeners implements ITestListener {
	Utilities uts = new Utilities();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Listeners on Start Test Line"+ result.getName()  );
		try {
			uts.takeSnapShot("On test start"+ uts.timereturn()+ ".png");
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Listeners success  Line"+ result.getName()  );
		try {
			uts.takeSnapShot("On test success"+ uts.timereturn()+ ".png");
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Listeners failing  Line"+ result.getName()  );
		try {
			uts.takeSnapShot("On test failure"+ uts.timereturn()+ ".png");
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Listeners on Start context"+ context.getName()  );
		try {
			uts.takeSnapShot("On start context"+ uts.timereturn()+ ".png");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Listeners on Finish context"+ context.getName()  );
		try {
			uts.takeSnapShot("On finish context"+ uts.timereturn()+ ".png");
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

}
