import { ReactNode } from "react";
import { ArtistContext } from "@/context/ArtistContext";
import { useEntity } from "@/hooks";
import { ArtistType } from "@/types";

export const ArtistProvider = ({ children }: { children: ReactNode }) => {
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<ArtistType>("http://localhost:8085/api/v1/artist");

  return (
    <ArtistContext.Provider
      value={{
        artistsList: state,
        addArtist: addEntity,
        deleteArtist: deleteEntity,
        updateArtist: updateEntity,
        getArtistById: getEntityById,
        searchArtists: searchEntityBy,
      }}
    >
      {children}
    </ArtistContext.Provider>
  );
};
