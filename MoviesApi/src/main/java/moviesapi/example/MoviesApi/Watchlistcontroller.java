package moviesapi.example.MoviesApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/watchlist")
@CrossOrigin(origins = "*")
public class Watchlistcontroller {
    @Autowired

    private WatchlistService watchlistService;

    @PostMapping("/{userid}/add")
    public ResponseEntity<Watchlist> addMovieToWatchlist(@PathVariable String userid, @RequestBody Movie movie) {
        Watchlist updatedWatchlist = watchlistService.addMovieToWatchlist(userid, movie);
        return ResponseEntity.ok(updatedWatchlist);
    }

    @DeleteMapping("/{userid}/remove/{movieId}")
    public ResponseEntity<Watchlist> removeMovieFromWatchlist(@PathVariable String userid, @PathVariable String movieId) {
        Watchlist updatedWatchlist = watchlistService.removeMovieFromWatchlist(userid, movieId);
        if (updatedWatchlist != null) {
            return ResponseEntity.ok(updatedWatchlist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userid}")
    public ResponseEntity<Watchlist> getWatchlist(@PathVariable String userid) {
        Watchlist watchlist = watchlistService.getWatchlist(userid);
        return ResponseEntity.ok(watchlist);
    }
}
