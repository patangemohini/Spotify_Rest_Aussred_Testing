package com.Spotify_rest_aussred_testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyRestAussredTesting {
    public String token = "Bearer BQCj6dE2PFBmVcIXxibHjNm04LN7eHO39-yv1r3JPrse08nY1_AVXZcNWOJ2lWSjzUQtlQnNam5mbDPfTpwfd4NzEXuydp1AEKZXlu9UKkaBkpvdVrtRSeeqrrqZ6sRWMdtu_rjzDKFVjifoGv39qQqVCPYKKthfzZgZhUljxzoTs4UjWlHrqlTRTdHFKBQQFCE6gw-Ykryicc4qq_nilyyBP5Heqdug1fZCK_p30gBBhv7R-sh9XQBSze92nhK99W7aWpXpzgdCOuEWpA_XiQ";
    public String userId = "31rleeotc5km4vgu5bfcpxmo27te";

    @Test
    public void GetCurrentUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        System.out.println("Current user's profile:" + userId);
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void GetUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/31rleeotc5km4vgu5bfcpxmo27te");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void createPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"name\": \"Bollywood\",\n" +
                        "  \"description\": \"New playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/31rleeotc5km4vgu5bfcpxmo27te/playlists");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }


    @Test
    public void addItemsToPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 1)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://api.spotify.com/v1/playlists/7ETQZY3b11YkoiEn4Pi4sS/tracks?uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getusersPlaylists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/smedjan/playlists?limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getPlaylistItems() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?market=ES&fields=items(added_by.id%2Ctrack(name%2Chref%2Calbum(name%2Chref)))&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetTrack() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getSeveralTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getTracksAudioFeachers() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getTracksAudioAnalysis() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getFollowedArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/following?type=artist&after=0I2XqVXqHScXjHhk6AYYRe&limit=10");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void checkIfUsersFollowPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=57dN52uHvrHOxijzpIgu3E");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void CheckIfUserFollowsArtistsOrUsers() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=57dN52uHvrHOxijzpIgu3E");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void unfollowArtistsOrUsers() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void unfollowPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getseveralArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists?ids=57dN52uHvrHOxijzpIgu3E");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getArtist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/57dN52uHvrHOxijzpIgu3E");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getArtistsTopTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getArtistsRelatedArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getAlbum() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getAlbumTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getRecommendations() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/recommendations?limit=10&market=ES&seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getNewReleases() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases?country=SE&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getFeaturedPlaylists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists?country=SE&locale=sv_SE&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getAvailableGenreSeeds() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getSeveralBrowseCategories() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories?country=SE&locale=sv_SE&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getShow() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getShowEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes?market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getSeveralShows() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows?market=ES&ids=5CfCWKI5pZ28U0uOzXkDHe");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getAvailableMarkets() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/markets");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getSeveralEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getAvailableDevices() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/player/devices");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getCurrentlyPlayingTrack() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/player/currently-playing?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(204);

    }


    @Test
    public void getUsersSavedShows() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/shows?limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void getUsersSavedEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/episodes?market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void checkUsersSavedShows() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/shows/contains?ids=5CfCWKI5pZ28U0uOzXkDHe");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void saveAlbums() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .put("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void removeTracksForCurrentUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void removeUsersSavedShows() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void removeAlbums() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void searchForItem() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/search?q=Carly%20Rae%20Jepsen&type=artist&market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}

