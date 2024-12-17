package moviesapi.example.MoviesApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "watchlist")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Watchlist {
    @Id
    private String userid;
    private List<Movie> list;
}
