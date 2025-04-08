export default function formatTime(duration: number | null) {
  if (duration === 0 || duration === null) return "00:00";
  const minutes = Math.floor(duration / 60);
  const seconds = duration % 60;
  return `${minutes}:${seconds < 10 ? "0" : ""}${seconds}`;
}
