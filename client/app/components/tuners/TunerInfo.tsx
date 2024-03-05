import { Tuner } from "@/app/types/Types";
import React from "react";
type Props = {
  tuner: Tuner;
};
export const TunerInfo = ({ tuner }: Props) => {
  const Ischromatic = tuner.chromatic ? "Yes" : "No";
  const hasIntegratedMicrophone = tuner.integrated_microphone ? "Yes" : "No";
  const hasIntegratedMetronome = tuner.integrated_metronome ? "Yes" : "No";
  return (
    <div className="flex flex-col text-xl items-center md:flex-row md:items-start md:justify-center">
      <ul className="w-3/4 shadow-lg m-2 md:w-1/3 p-5">
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 md:mt-1">Brand:</p>
          <p className="mb-1">{tuner.brand.name}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Display:</p>
          <p className="mb-1 mt-1">{tuner.display}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Design:</p>
          <p className="mb-1 mt-1">{tuner.design}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Chromatic:</p>
          <p className="mb-1 mt-1">{Ischromatic}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Integrated Microphone:</p>
          <p className="mb-1 mt-1">{hasIntegratedMicrophone}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Integrated Metronome:</p>
          <p className="mb-1 mt-1">{hasIntegratedMetronome}</p>
        </li>
      </ul>
    </div>
  );
};
