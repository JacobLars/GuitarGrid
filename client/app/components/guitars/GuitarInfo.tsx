import { Guitar } from "@/app/types/Types";
import React from "react";
type Props = {
  guitar: Guitar;
};
export const GuitarInfo = ({ guitar }: Props) => {
  console.log(guitar.bodyType);
  return (
    <div>
      <h1>{guitar.pickups}</h1>
    </div>
  );
};
