import { ReactNode } from "react";
import { SongContext } from "@/context/SongContext";
import { useEntity } from "@/hooks";
import { SongType } from "@/types";

export const SongProvider = ({ children }: { children: ReactNode }) => {
  const { state, addEntity, deleteEntity, updateEntity, getEntityById } =
    useEntity<SongType>( "http://localhost:8085/api/v1/song/json");

  return (
    <SongContext.Provider
      value={{
        songsList: state,
        addSong: addEntity,
        deleteSong: deleteEntity,
        updateSongsList: updateEntity,
        getSongById: getEntityById,
      }}
    >
      {children}
    </SongContext.Provider>
  );
};
