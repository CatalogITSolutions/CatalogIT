package testCases;

import org.openqa.selenium.WebDriver;

import generalUtilities.BrowserSetup;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;
import generalUtilities.Readxlsx;
import generalUtilities.Snippet;
import pageObjects.Admin.AccessRoles;
import pageObjects.Admin.AddAdmin;
import pageObjects.Admin.AddContactDetails;
import pageObjects.Admin.Dashboard;
import pageObjects.Admin.ExamQuestionPaper;
import pageObjects.Admin.Login;
import pageObjects.Admin.ResultsCalculation;
import pageObjects.Admin.SetExamPattern;
import pageObjects.Admin.StudentExamStatus;
import pageObjects.Admin.SubmitExam;
import pageObjects.Admin.UpdateKey;
import pageObjects.Admin.UploadCarousel;
import pageObjects.Admin.UploadLogo;
import pageObjects.Admin.UsersLogData;
import pageObjects.Admin.Welcome;
import pageObjects.Student.BookmarkQuestions;
import pageObjects.Student.Profile;
import pageObjects.Student.Rank;
import pageObjects.Student.Result;
import pageObjects.Student.SPA;
import pageObjects.Student.StLogin;
import pageObjects.Student.StLoginPageFactory;
import pageObjects.Student.StartTest;

public class TestCases {

	WebDriver driver;
	BrowserSetup brsetup;
	ReadProperties readprop;
	Readxlsx readxlsx;
	ReadXL readxl;
	Welcome welc;
	Login login;
	Snippet snip;
	Dashboard dash;

	/* --- Student Variable ------- */
	StLogin stlogin;
	StartTest stTest;
	BookmarkQuestions stBookmark;
	SPA stSPA;
	Profile stProfile;
	Rank stRank;
	Result stResult;
	StLoginPageFactory stLoginPF;

	UsersLogData userlog;
	StudentExamStatus exStatus;
	AddContactDetails contact;
	ResultsCalculation rsCal;
	UpdateKey upKey;
	UploadCarousel upCar;
	UploadLogo uplogo;
	SetExamPattern exPattern;
	ExamQuestionPaper exQus;
	SubmitExam exSubmit;
	AddAdmin addadmin;
	AccessRoles roles;

	public TestCases() {
		// TODO Auto-generated constructor stub
		readprop = new ReadProperties("testData/Data.properties");
		readxlsx = new Readxlsx("testData/Dataxlsx.xlsx");
		readxl = new ReadXL("testData/Dataxl.xls");
		brsetup = new BrowserSetup();
		driver = brsetup.driverType();
		/* --- Admin Page objects ------- */
		welc = new Welcome(driver);
		login = new Login(driver);
		snip = new Snippet(driver);
		dash = new Dashboard(driver);
		userlog = new UsersLogData(driver);
		exStatus = new StudentExamStatus(driver);
		contact = new AddContactDetails(driver);
		rsCal = new ResultsCalculation(driver);
		upKey = new UpdateKey(driver);
		upCar = new UploadCarousel(driver);
		uplogo = new UploadLogo(driver);
		exPattern = new SetExamPattern(driver);
		exQus = new ExamQuestionPaper(driver);
		exSubmit = new SubmitExam(driver);
		addadmin = new AddAdmin(driver);
		roles = new AccessRoles(driver);

		/* --- Student Page objects ------- */
		stlogin = new StLogin(driver);
		stTest = new StartTest(driver);
		stBookmark = new BookmarkQuestions(driver);
		stSPA = new SPA(driver);
		stProfile = new Profile(driver);
		stRank = new Rank(driver);
		stResult = new Result(driver);
		stLoginPF = new StLoginPageFactory(driver);
	}

	/* ****** ADMIN TESTCASE ******* */

	/* ******* 1. goToApplication ******* */

	public boolean goToApplication() {
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		login.logoutFromApplication();
		return true;
	}
	/* ******* 2. usersLogData ******* */

	public void usersLogData() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc usersLogData");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		userlog.userlogs();
		login.logoutFromApplication();
		System.out.println(" End tc: tc usersLogData");
	}

	/* ******* 3. studentExamStatus ******* */

	public void studentExamStatus() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc studentExamStatus");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		exStatus.examStatus();
		login.logoutFromApplication();
		System.out.println(" End tc: tc studentExamStatus");
	}

	/* ******* 4. addContactDetails ******* */

	public void addContactDetails() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc addContactDetails");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		contact.addContact();
		login.logoutFromApplication();

		System.out.println(" End tc: tc addContactDetails");
	}

	/* ******* 5. resultsCalculation ******* */

	public void resultsCalculation() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc resultsCalculation");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		rsCal.calculation();
		login.logoutFromApplication();

		System.out.println(" End tc: tc resultsCalculation");
	}

	/* ******* 6. updateKey ******* */

	public void updateKey() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc updateKey");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		upKey.keyUpload();
		login.logoutFromApplication();
		System.out.println(" End tc: tc updateKey");
	}

	/* ******* 7. uploadCarousel ******* */

	public void uploadCarousel() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc uploadCarousel");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		upCar.carouselSlide();
		login.logoutFromApplication();

		System.out.println(" End tc: tc uploadCarousel");
	}

	/* ******* 8. uploadLogo ******* */

	public void uploadLogo() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc uploadLogo");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		uplogo.clientlogo();
		login.logoutFromApplication();

		System.out.println(" End tc: tc uploadLogo");
	}

	/* ******* 9. setExamPattern ******* */

	public void setExamPattern() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc setExamPattern");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		exPattern.examPattern();
		login.logoutFromApplication();

		System.out.println(" End tc: tc setExamPattern");
	}

	/* ******* 10. examQuestionPaper ******* */

	public void examQuestionPaper() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc examQuestionPaper");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		exQus.examQuestions();
		login.logoutFromApplication();

		System.out.println(" End tc: tc examQuestionPaper");
	}

	/* ******* 11. submitExam ******* */

	public void submitExam() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc submitExam");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		exSubmit.submitExam();
		login.logoutFromApplication();
		System.out.println(" End tc: tc submitExam");
	}

	/* ******* 12. Add Admin ******* */

	public void addAdmin() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc addAdmin");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		addadmin.addadminBySuperAdmin();
		login.logoutFromApplication();
		System.out.println(" End tc: tc addAdmin");
	}

	public void accessRole() {
		// TODO Auto-generated method stub
		System.out.println(" Start tc: tc accessRole");
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		roles.assignRoles();
		login.logoutFromApplication();
		System.out.println(" End tc: tc accessRole");

	}

	private static String adminSheet = "AdminDataDriven";

	public void adminDataDrivenTestCase() {
		// TODO Auto-generated method stub

		for (int i = 0; i < readxl.getRowCount(adminSheet); i++) {

			welc.launchApplication();
			System.out.println("loop count =" + i);
			System.out.println(readxl.getRowCount(adminSheet));
			System.out.println((readxl.getCellData(adminSheet, 0, i) + readxl.getCellData(adminSheet, 1, i)));
			login.loginToAdminDataDriven(readxl.getCellData(adminSheet, 0, i), readxl.getCellData(adminSheet, 1, i));
			login.switchWindow();
			login.logoutFromApplication();
			welc.closeApplication();

		}

	}

	// /// //// ///// ========== Student TestCases ==========================

	public boolean studentLoginAndLogoutPageFactory() {
		System.out.println(" Start tc: tc studentLoginAndLogout");
		welc.launchApplication();
		stLoginPF.loginToStudentUsingPageFactory();
		stLoginPF.switchWindow();
		stLoginPF.logoutFromStudent();
		// dash.selectState();
		System.out.println(" End tc: tc studentLoginAndLogout");
		return true;
	}

	/* ******* 12. studentLoginAndLogout ******* */

	public boolean studentLoginAndLogout() {
		System.out.println(" Start tc: tc studentLoginAndLogout");
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stlogin.logoutFromStudent();
		// dash.selectState();
		System.out.println(" End tc: tc studentLoginAndLogout");
		return true;
	}

	/* ******* 13. studentStartTest ******* */

	public boolean studentStartTest() {
		System.out.println(" Start tc: tc studentStartTest");
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stTest.viewStartTest();
		stlogin.logoutFromStudent();
		System.out.println(" End tc: tc studentStartTest");
		return true;
	}

	/* ******* 14. studentBookmarkQuestions ******* */

	public boolean studentBookmarkQuestions() {
		System.out.println(" Start tc: tc studentBookmarkQuestions");
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stBookmark.viewBookmarkQuestions();
		stlogin.logoutFromStudent();
		endDriver();
		System.out.println(" End tc: tc studentBookmarkQuestions");
		return true;
	}

	/* ******* 15. studentSPA ******* */

	public boolean studentSPA() {
		System.out.println(" Start tc: tc studentSPA");
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stSPA.viewSPA();
		stlogin.logoutFromStudent();
		endDriver();
		System.out.println(" End tc: tc studentSPA");
		return true;
	}

	/* ******* 16. studentProfile ******* */

	public boolean studentProfile() {
		System.out.println(" Start tc: tc studentProfile");
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stProfile.editProfile();
		stlogin.logoutFromStudent();
		endDriver();
		System.out.println(" End tc: tc studentProfile");
		return true;
	}

	/* ******* 17. studentPassword ******* */

	public boolean studentPassword() {
		System.out.println(" Start tc: tc studentPassword");
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stProfile.changePassword();
		stlogin.logoutFromStudent();
		endDriver();
		System.out.println(" End tc: tc studentPassword");
		return true;
	}

	/* ----- Student Data driven --------- */

	/* ******* 18. student Login DataDrivenTestCase ******* */
	private static String sheetName = "StudentDataDriven";

	public void studentDataDrivenTestCase() {
		// TODO Auto-generated method stub

		for (int i = 0; i < readxlsx.getRowCount(adminSheet); i++) {

			welc.launchApplication();
			System.out.println("loop count" + i);
			System.out.println(readxlsx.getRowCount(adminSheet));
			System.out.println((readxlsx.getCellData(adminSheet, i, 0) + readxlsx.getCellData(adminSheet, i, 1)));
			// System.out.println(readxl.getCellData(xlfile, 0,
			// i)+readxl.getCellData(xlfile, 1, i));
			stlogin.loginToStudentDataDriven(readxlsx.getCellData(adminSheet, i, 0),
					readxlsx.getCellData(adminSheet, i, 1));
			stlogin.switchWindow();
			stlogin.logoutFromStudentDataDriven();
			welc.closeApplication();

		}
	}

	public String TakeErrorScreenShot(String string) {
		// TODO Auto-generated method stub
		return snip.TakeErrorScreenShot(string);
	}

	public void endDriver() {
		// TODO Auto-generated method stub
		driver.quit();
	}

} /* **** END CLASS *********************/
