package kodlamaio.hrms.core.utilities.helpers;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {
	
	public static Result run(Result... results) {
		for(Result result:results) {
			if(!result.isSuccess()) {
				return result;
			}
		}
		return new SuccessResult();
	}
}
