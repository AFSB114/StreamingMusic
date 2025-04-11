import { ReactNode } from "react";
import { SongContext } from "@/context/SongContext";
import { useEntity } from "@/hooks";
import { SongType } from "@/types";

export const SongProvider = ({ children }: { children: ReactNode }) => {
  const apiUrl = process.env.NEXT_PUBLIC_API_URL
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<SongType>(`${apiUrl}/song`);

  return (
    <SongContext.Provider
      value={{
        songsList: state,
        addSong: addEntity,
        deleteSong: deleteEntity,
        updateSong: updateEntity,
        getSongById: getEntityById,
        searchSongs: searchEntityBy,
      }}
    >
      {children}
    </SongContext.Provider>
  );
};
