import { ReactNode } from "react";
import { GenreContext } from "@/context/GenreContext";
import { useEntity } from "@/hooks";
import { GenreType } from "@/types";

export const GenreProvider = ({ children }: { children: ReactNode }) => {
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<GenreType>("http://localhost:8085/api/v1/genre");

  return (
    <GenreContext.Provider
      value={{
        genresList: state,
        addGenre: addEntity,
        deleteGenre: deleteEntity,
        updateGenre: updateEntity,
        getGenreById: getEntityById,
        searchGenres: searchEntityBy,
      }}
    >
      {children}
    </GenreContext.Provider>
  );
};