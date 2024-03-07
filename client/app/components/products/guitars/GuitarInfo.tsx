import { Guitar } from "@/app/types/Types";
import React from "react";
type Props = {
  guitar: Guitar;
};
export const GuitarInfo = ({ guitar }: Props) => {
  return (
    <div className="flex flex-col text-xl items-center md:flex-row md:items-start md:justify-center">
      <ul className="w-3/4 shadow-lg m-2 md:w-1/3 p-5">
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 md:mt-1">Brand:</p>
          <p className="mb-1">{guitar.brandName}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Type:</p>
          <p className="mb-1 mt-1">{guitar.type}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Pickups:</p>
          <p className="mb-1 mt-1">{guitar.pickups}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Scale:</p>
          <p className="mb-1 mt-1">{guitar.scale}mm</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Frets:</p>
          <p className="mb-1 mt-1">{guitar.frets}</p>
        </li>
      </ul>
      <ul className="w-3/4 shadow-lg m-2 md:w-1/3 p-5">
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Color:</p>
          <p className="mb-1 mt-1">{guitar.color}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Neck:</p>
          <p className="mb-1 mt-1">{guitar.neckType}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Body:</p>
          <p className="mb-1 mt-1">{guitar.bodyType}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Fretboard:</p>
          <p className="mb-1 mt-1">{guitar.fretboardType}</p>
        </li>
      </ul>
    </div>
  );
};
