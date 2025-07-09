export default class Song {
  constructor(
    private id: number,
    private title: string,
    private composer: string,
    private duration: number,
    private lyrics: string,
    private release_date: string,
    private track_number: number,
    private album_id: number | null,
    private artist_id: number,
    private file_url: string,
    private image_url: string
  ) {
    this.id = id;
    this.title = title;
    this.composer = composer;
    this.duration = duration;
    this.lyrics = lyrics;
    this.release_date = release_date;
    this.track_number = track_number;
    this.album_id = album_id;
    this.artist_id = artist_id;
    this.file_url = file_url;
    this.image_url = image_url;
  }

  public getId(): number {
    return this.id;
  }
  
  public setId(id: number): void {
    this.id = id;
  }

  public getTitle(): string {
    return this.title;
  }

  public setTitle(title: string): void {
    this.title = title;
  }

  public getComposer(): string {
    return this.composer;
  }

  public setComposer(composer: string): void {
    this.composer = composer;
  }

  public getDuration(): number {
    return this.duration;
  }

  public setDuration(duration: number): void {
    this.duration = duration;
  }

  public getLyrics(): string {
    return this.lyrics;
  }

  public setLyrics(lyrics: string): void {
    this.lyrics = lyrics;
  }

  public getReleaseDate(): string {
    return this.release_date;
  }

  public setReleaseDate(release_date: string): void {
    this.release_date = release_date;
  }

  public getTrackNumber(): number {
    return this.track_number;
  }

  public setTrackNumber(track_number: number): void {
    this.track_number = track_number;
  }

  public getAlbumId(): number | null {
    return this.album_id;
  }

  public setAlbumId(album_id: number | null): void {
    this.album_id = album_id;
  }

  public getArtistId(): number {
    return this.artist_id;
  }

  public setArtistId(artist_id: number): void {
    this.artist_id = artist_id;
  }

  public getFileUrl(): string {
    return this.file_url;
  }

  public setFileUrl(file_url: string): void {
    this.file_url = file_url;
  }

  public getImageUrl(): string {
    return this.image_url;
  }

  public setImageUrl(image_url: string): void {
    this.image_url = image_url;
  }
}
