package configs;

import play.GlobalSettings;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

public class Global extends GlobalSettings {

	  private class ActionWrapper extends Action.Simple {
	    public ActionWrapper(Action action) {
	     this.delegate = action;
	  }

	    @Override
	    public Result call(Http.Context ctx) throws java.lang.Throwable {
	      Result result = this.delegate.call(ctx);
	      Http.Response response = ctx.response();
	      response.setHeader("Access-Control-Allow-Origin", "*");
	      response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
	      response.setHeader("Access-Control-Max-Age", "86400");
	      response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With, Accept");
	      return result;
	    }
	  }

	  @Override
	  public Action onRequest(Http.Request request, java.lang.reflect.Method actionMethod) {
	    return new ActionWrapper(super.onRequest(request, actionMethod));
	  }

	}