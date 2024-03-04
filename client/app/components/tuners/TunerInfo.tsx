import { Tuner } from "@/app/types/Types";
import React from "react";
type Props = {
  tuner: Tuner;
};
export const TunerInfo = ({ tuner }: Props) => {
  return (
    <div>
      <h1>{tuner.design}</h1>
    </div>
  );
};
