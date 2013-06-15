import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.entities.Category;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;


public class Main {
	  public void searchVenues(String ll) throws FoursquareApiException {
		    // First we need a initialize FoursquareApi. 
		    FoursquareApi foursquareApi = new FoursquareApi("BWEAGCZDWFU2ICIZXBB05XVCOCBWMSQ44GZLXACG4JIMJF2N", "TM4HTR0OAGGBYJITUFWPLTWISMMRHLCDJWW1CB0DE3M5XPTC", "");
		    
		    // After client has been initialized we can make queries.
		    fi.foyt.foursquare.api.Result<VenuesSearchResult> result = foursquareApi.venuesSearch(ll, null, null, null, null, null, null, null, null, null, null);
		    if (result.getMeta().getCode() == 200) {
		      // if query was ok we can finally we do something with the data
		      for (CompactVenue venue : result.getResult().getVenues()) {
		        // TODO: Do something we the data
		        System.out.print(venue.getName() + " -> ");
		        for (Category cat : venue.getCategories()){
		        	System.out.print(cat.getName());
		        }
		       
		        System.out.println();
		      
		      }
		    } else {
		      // TODO: Proper error handling
		      System.out.println("Error occured: ");
		      System.out.println("  code: " + result.getMeta().getCode());
		      System.out.println("  type: " + result.getMeta().getErrorType());
		      System.out.println("  detail: " + result.getMeta().getErrorDetail()); 
		    }
		  }
		public static void main(String[] args) throws FoursquareApiException{
			Main m = new Main();
			m.searchVenues("41.89,12.485");
		}

}
