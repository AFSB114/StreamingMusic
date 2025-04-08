import { ReactNode } from "react";
import { SongContext } from "@/context/SongContext";
import { useEntity } from "@/hooks";
import { SongType } from "@/types";

export const SongProvider = ({ children }: { children: ReactNode }) => {
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<SongType>( "http://localhost:8085/api/v1/song");

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
